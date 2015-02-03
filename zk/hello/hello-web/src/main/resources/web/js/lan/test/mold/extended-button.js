function (out) {
	var tabi = this._tabindex;

	out.push('<div ', this.domAttrs_());
	if (this._disabled) out.push(' disabled="disabled"');
	if (tabi) out.push(' tabindex="', tabi, '"');
	out.push('>', this.domContent_(), '</div>');
}