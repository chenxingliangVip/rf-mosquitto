<template>
	<div class="imgupload">
		<div class="imgItemParent">
			<div class="imgItem">
				<span class="clickUP" v-show="!pageImgs.url">点击上传照片</span>
				<img class="content" :src="pageImgs.url" v-show="pageImgs.url">

				<input type="file" accept="image/*" @change="imgChange($event)" 
					multiple :disabled="disabled" :class="{ 'isdisabled': disabled }">
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
</template>

<script>
	export default {
		props: ['imgList', 'disabled', 'isIco'],
		data() {
			return {
				pageImgs: {}
			}
		},
		methods: {
			setParentImglist() {
				this.$emit('update:imgList', JSON.parse(JSON.stringify(this.pageImgs)))
			},
			imgChange(e, index) { //选择文件
				if(e.target.files.length) {
					let file = e.target.files[0];
					console.log(file.type)
					if(this.isIco){
						if(file.type !== 'image/x-icon') {
                			this.$message.warning("浏览器logo文件格式为ico！");
							return false
						}
					}else {
						if(file.type !== 'image/png' && file.type !== 'image/jpeg') {
                			this.$message.warning("LOGO图片文件格式为PNG或JPG！");
							return false
						}
					}
					var reader = new FileReader();
					reader.readAsDataURL(file);
					reader.onload = (eve) => {
						this.pageImgs = {
							file: e.target.files[0],
							url: eve.target.result,
							name: file.name,
						}
						this.setParentImglist();
					}
				}
			}
		},
	}
</script>

<style scoped lang="scss">
	.imgupload {
		width: 100%;
		.imgItemParent {
			float: left;
			margin-right: 20px;
			width: 100%;
		}
		.imgItem {
			border: 1px solid #DCDFE6;
			width: 100%;
			height: 130px;
			border-radius: 8px;
			box-sizing: border-box;
			position: relative;
			display: flex;
			align-items: center;
			justify-content: center;
			background-color: #fbfdff;
			.el-icon-plus {
				font-size: 30px;
				color: #DCDFE6;
			}
			.el-icon-delete {
				font-size: 12px;
				position: absolute;
				right: 0;
				top: 0;
				padding: 5px;
				cursor: pointer;
				z-index: 2;
				background: #8e8888b8;
				color: #ffffff;
			}
			input {
				position: absolute;
				width: 100%;
				height: 100%;
				opacity: 0;
				cursor: pointer;
				&.isdisabled {
					cursor: no-drop;
				}
			}
			.content {
				max-width: 100%;
				max-height: 100%;
			}
			.click {
				font-size: 12px;
			}
            .clickUP {
                color: #c1c7d5;
            }
		}
	}
</style>