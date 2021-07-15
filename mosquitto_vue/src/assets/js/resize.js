//获取缩放样式
let setScale = () => {
	var width = document.body.clientWidth;
	var height = document.body.clientHeight;
	var scaleX = width / 1920;
	var scaleY = height / 1080;
	var scale = '';
	var mleft = '';
	// if(scaleX > scaleY) {
	// 	scale = scaleY;
	// 	mleft = (width - 1920 * scaleY) / 2;
	// } else {
		scale = scaleX;
	// };
	return {
		'transform': 'scaleX(' + scale + ')',
		'display': 'block'
	}
};

export default {
	setScale,
};