zAu.cmd0.showPointerPopup = function (title, msg, desc, type, pid, ref, pos, off, dur, closable) {
	var notif = (lan && lan.test) ? lan.test.PointerPopupWindow : null;
	if (notif) {
		notif.show(msg, pid, {ref:ref, pos:pos, off:off, dur:dur, type:type, closable:closable, title:title, desc:desc});
	} else {

		jq.alert(msg);
	}
};

(function () {
	var _iconMap = {
		'warning': 'z-icon-exclamation-circle',
		'info': 'z-icon-info-circle',
		'error': 'z-icon-times-circle'
	};
	var _dirMap = {
		'u': 'up',
		'd': 'down',
		'l': 'left',
		'r': 'right'
	};

lan.test.PointerPopupWindow = zk.$extends(zul.wgt.Notification, {

	$init: function (msg, opts) {
		this.$supers(zul.wgt.Notification, '$init', arguments);
		this._title = opts.title;
		this._desc = opts.desc;
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
		out.push('<div id="', uuid, '-cave" class="', this.$s('content'), '">');
		out.push('<div id="', uuid, '-title-cave" class="', this.$s('title'), '">');
		out.push('<div id="', uuid, '-title-image-cave" class="', this.$s(this._type +'-image'), '">&nbsp;</div>');
		out.push('<div id="', uuid, '-title-text-cave" class="', this.$s('title-text'), '">',
				this._msg, '</div>');
		out.push('</div>');
		out.push('<div id="', uuid, '-msg-cave" class="', this.$s('msg'), '">',
				this._msg, '</div>');
		out.push('<div id="', uuid, '-desc-cave" class="', this.$s('desc'), '">',
				this._desc, '</div>');
		out.push('</div>');
		if (this._closable)
			out.push('<div id="', uuid, '-cls" class="', this.$s('close'),
					'"><i id="', uuid, '-clsIcon" class="', icon, ' z-icon-times"></i></div>');
		out.push('</div>');
	}
}, {
	show: function (msg, pid, opts) {
		if (!opts)
			opts = {};
		var parent = zk.Widget.$(pid),
				ref = opts.ref,
				pos = opts.pos,
				dur = opts.dur,
				title = opts.title;
				desc = opts.desc;
				ntf = new lan.test.PointerPopupWindow(msg, opts),
				off = opts.off;



		if (!pos && !off)
			pos = ref ? "end_center" : "middle_center";

		if (!parent) {

			parent = zk.Desktop.$().firstChild;
		}
		parent.appendChild(ntf);
		ntf.open(ref, off, pos);


		if (dur > 0)
			setTimeout(function () {
				if (ntf.desktop)
					ntf.close();
			}, dur);
	}

});

})();