lan.test.ExtendedButton=zk.$extends(zul.wgt.Button,{domContent_:function(){var e=zUtl.encodeXML(this.getLabel()),t=this.getImage(),n=this.domIcon_();if(!t&&!n)return e;e='"<div class="'+this.$s("label")+'">'+e+"</div>";if(!t)t=n;else t='<img class="'+this.$s("image")+'" src="'+t+'" />'+(n?" "+n:"");var r="vertical"==this.getOrient()?"<br/>":" ";return this.getDir()=="reverse"?e+r+t:t+r+e}})