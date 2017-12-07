/* Copyright Bryan W Berry, 2009, 
 * under the MIT license http://www.opensource.org/licenses/mit-license.php
 * 
 * this library is heavily influenced by the GNU LIBC library
 *  http://www.gnu.org/software/libc/manual/html_node/Locales.html
 */

(function($){

	$.i18n = function(string, locale){
		var lang = locale || $.i18n.lang;
		if (!this.i18n[lang] || !this.i18n[lang].strings){
			return string;
		}
		return this.i18n[lang].strings[string]||string;
	};

	$._ = $.i18n;

	$.i18n.setLocale = function (locale){
		$.i18n.lang = locale;
	};

	$.i18n.getLocale = function (){
		return $.i18n.lang;
	};


	/**
	* Converts a number to numerals in the specified locale. Currently only
	* supports devanagari numerals for Indic languages like Nepali and Hindi
	* @param {Number} Number to be converted
	* @param {locale} locale that number should be converted to
	* @returns {String} Unicode string for localized numeral 
	*/
	$.i18n._n = function(num, locale){

		locale = locale || $.i18n.lang;

		if (!this.i18n[locale] || !this.i18n[locale].numBase ){
			return num;
		}

		//48 is the base for western numerals
		var numBase = $.i18n[$.i18n.lang].numeralBase || 48;
		var prefix =  $.i18n[$.i18n.lang].numeralPrefix || "u00";

		var convertDigit = function(digit){	     
			return '\\' + prefix + (numBase + parseInt(digit)).toString(16);
		};

		var charArray = num.toString().split("").map(convertDigit);
		return eval('"' + charArray.join('') + '"');
	};

	$._n = $.i18n._n;

	$._d = $.i18n._d = function (date, mask, utc) {
		var token = /d{1,4}|m{1,4}|yy(?:yy)?|([HhMsTt])\1?|[LloSZ]|"[^"]*"|'[^']*'/g,
		timezone = /\b(?:[PMCEA][SDP]T|(?:Pacific|Mountain|Central|Eastern|Atlantic) (?:Standard|Daylight|Prevailing) Time|(?:GMT|UTC)(?:[-+]\d{4})?)\b/g,
		timezoneClip = /[^-+\dA-Z]/g,
		pad = function (val, len) {
			val = String(val);
			len = len || 2;
			while (val.length < len) val = "0" + val;
			return val;
		};

		// Regexes and supporting functions are cached through closure
		return $.i18n._date(date, mask, utc, token, timezone, timezoneClip, pad);
	};

	$.i18n._date = function (date, mask, utc, token, timezone, timezoneClip, pad) {
		//var dF = dateFormat;
		var locale = $.i18n.getLocale();
		var dateMasks = $.i18n[locale].date.dateMasks;
		var dayNamesShort = $.i18n[locale].date.dayNamesShort;
		var dayNames = $.i18n[locale].date.dayNames;
		var monthNames = $.i18n[locale].date.monthNames;
		var monthNamesShort = $.i18n[locale].date.monthNamesShort;

		// You can't provide utc if you skip other args (use the "UTC:" mask prefix)
		if (arguments.length == 1 && Object.prototype.toString.call(date) == "[object String]" && !/\d/.test(date)) {
			mask = date;
			date = undefined;
		}

		// Passing date through Date applies Date.parse, if necessary
		date = date ? new Date(date) : new Date;
		if (isNaN(date)) throw SyntaxError("invalid date");

		mask = String(dateMasks[mask] || mask || dateMasks["default"]);

		// Allow setting the utc argument via the mask
		if (mask.slice(0, 4) == "UTC:") {
			mask = mask.slice(4);
			utc = true;
		}

		var	_ = utc ? "getUTC" : "get",
			d = date[_ + "Date"](),
			D = date[_ + "Day"](),
			m = date[_ + "Month"](),
			y = date[_ + "FullYear"](),
			H = date[_ + "Hours"](),
			M = date[_ + "Minutes"](),
			s = date[_ + "Seconds"](),
			L = date[_ + "Milliseconds"](),
			o = utc ? 0 : date.getTimezoneOffset(),
			flags = {
				d:    d,
				dd:   pad(d),
				ddd:  dayNamesShort[D],
				dddd: dayNames[D],
				m:    m + 1,
				mm:   pad(m + 1),
				mmm:  monthNamesShort[m],
				mmmm: monthNames[m],
				yy:   String(y).slice(2),
				yyyy: y,
				h:    H % 12 || 12,
				hh:   pad(H % 12 || 12),
				H:    H,
				HH:   pad(H),
				M:    M,
				MM:   pad(M),
				s:    s,
				ss:   pad(s),
				l:    pad(L, 3),
				L:    pad(L > 99 ? Math.round(L / 10) : L),
				t:    H < 12 ? "a"  : "p",
				tt:   H < 12 ? "am" : "pm",
				T:    H < 12 ? "A"  : "P",
				TT:   H < 12 ? "AM" : "PM",
				Z:    utc ? "UTC" : (String(date).match(timezone) || [""]).pop().replace(timezoneClip, ""),
				o:    (o > 0 ? "-" : "+") + pad(Math.floor(Math.abs(o) / 60) * 100 + Math.abs(o) % 60, 4),
				S:    ["th", "st", "nd", "rd"][d % 10 > 3 ? 0 : (d % 100 - d % 10 != 10) * d % 10]
			};

		return mask.replace(token, function ($0) {
			return $0 in flags ? flags[$0] : $0.slice(1, $0.length - 1);
		});
	};

	/* ToDo
	* implement sprintf
	* conversion functions for monetary and numeric 
	* sorting functions (collation) for different locales
	*/
	
	String.prototype.format = function() {
	    var formatted = this;
	    for (var i = 0; i < arguments.length; i++) {
		var regexp = new RegExp('\\{'+i+'\\}', 'gi');
		formatted = formatted.replace(regexp, arguments[i]);
	    }
	    return formatted;
	};

	// For convenience...
	Date.prototype.format = function (mask, utc) {
		return $.i18n._d(this, mask, utc);
	};


})(jQuery);

