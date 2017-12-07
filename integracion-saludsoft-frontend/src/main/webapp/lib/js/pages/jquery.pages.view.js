$.widget('integracionsaludsoft.pageView', {
	options : {
		appCtx : ''
	},

	_create : function() {
		this._bindVars();
		this._bindEvents();
		this._initialize();
	},

	_bindVars : function() {
		this.$form = this.element.find("#frm-servicio");
	},

	_bindEvents : function() {
		this.element.find('#btn-volver').click($.proxy(this._backToIndex, this));
	},

	_initialize : function() {
		this.$form.form();
	},

	_backToIndex : function() {
		window.location = this.options.appCtx + 'servicios/views/index.do';
	},

	destroy : function() {
	}
});
