zk.afterLoad("zul.sel", function () {
	var e = {};
	zk.override(zul.sel.SelectWidget.prototype, e, {
		fireOnSelect: function (ref, evt) {
			var data = [];
			for (var it = this.getSelectedItems(), j = it.length; j--;)
				if (it[j].isSelected())
					data.push(it[j]);

			var edata, keep = true;
			var checkSelectAll = (evt.domTarget.id && evt.domTarget.id.endsWith('-cm'))
					|| (evt.domTarget.parentNode.id && evt.domTarget.parentNode.id.endsWith('-cm'));
			if (evt) {
				edata = evt.data;
				if (this._multiple)
					keep = (edata.ctrlKey || edata.metaKey) || edata.shiftKey ||
					       (this._checkmark && (!this._cdo || checkSelectAll));
			}

			this.fire('onSelect', zk.copy({items: data, reference: ref, clearFirst: !keep, selectAll: checkSelectAll}, edata));
		}
	})
});
