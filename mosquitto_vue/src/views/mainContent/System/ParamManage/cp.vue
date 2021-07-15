<template>
    <div class="addProject">
        
    </div>
</template>
<script>
export default {
    data() {
        return {
        };
    },
    methods: {
        
        setFormData() {
            this.$emit("addForm", '');
        },
    },
};
</script>
<style lang="scss" scoped>
@import "@/assets/style/dialog.scss";
</style>