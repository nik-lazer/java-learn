lan.test.IteratorListbox = zk.$extends(zul.sel.Listbox, {
	_afterCalcSize: function () {
		this.$supers('_afterCalcSize', arguments);
		var allWidths = this._isAllWidths();
		if (allWidths) {
			var hdtbl = this.eheadtbl;
			if (hdtbl && hdtbl.style.width) {
				if (this.paging) {
					this.paging.setWidth(hdtbl.style.width);
				}
				this.fire('onIteratorSize', {width: hdtbl.style.width}, {toServer: true});
			}
		}
	}
});