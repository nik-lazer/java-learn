zAu.cmd0.showPointerPopup = function (msg, type, pid, ref, pos, off, dur, closable) {
	var notif = (zul && zul.wgt) ? zul.wgt.Notification : null;
	if (notif) {
		notif.show(msg, pid, {ref:ref, pos:pos, off:off, dur:dur, type:type, closable:closable});
	} else {

		jq.alert(msg);
	}
};

lan.test.PointerPopupWindow = zk.$extends(zul.wgt.Notification, {

	$init: function (msg, opts) {
		this.$supers(zul.wgt.Notification, '$init', arguments);
		this._msg = msg;
		this._type = opts.type;
		this._ref = opts.ref;
		this._dur = opts.dur;
		this._closable = opts.closable;
	},
	redraw: function (out) {
		var uuid = this.uuid,
				icon = this.$s('icon');
		out.push('<div', this.domAttrs_(), '>');
		if (this._ref)
			out.push('<div id="', uuid, '-p" class="', this.$s('pointer'), '"></div>');
		out.push('<i id="', uuid, '-icon" class="', icon, ' ', (_iconMap[this._type]), '"></i>');
		out.push('<div id="', uuid, '-cave" class="', this.$s('content'), '">',
				this._msg, '</div>');
		if (this._closable)
			out.push('<div id="', uuid, '-cls" class="', this.$s('close'),
					'"><i id="', uuid, '-clsIcon" class="', icon, ' z-icon-times"></i></div>');
		out.push('</div>');
	}
});