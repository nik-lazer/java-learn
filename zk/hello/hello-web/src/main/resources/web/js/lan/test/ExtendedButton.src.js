lan.test.ExtendedButton = zk.$extends(zul.wgt.Button, {
	domContent_: function () {
		var label = zUtl.encodeXML(this.getLabel()),
				img = this.getImage(),
				iconSclass = this.domIcon_();
		if (!img && !iconSclass) return label;
		label = '<div class="' + this.$s('label') + '">'+ label + '</div>';

		if (!img) img = iconSclass;
		else
			img = '<img class="' + this.$s('image') + '" src="' + img + '" />'
					+ (iconSclass ? ' ' + iconSclass : '');
		var space = "vertical" == this.getOrient() ? '<br/>': ' ';
		return this.getDir() == 'reverse' ?
		       label + space + img: img + space + label;
	}

});