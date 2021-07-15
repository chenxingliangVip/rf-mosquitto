<template>
    <div class="QcPage">
        <QcMenu @showFun='getShow'></QcMenu>
        <div class="RunPageBody">
            <mine-task v-if="showNav==1"></mine-task>
            <wait-task v-else-if="showNav==2"></wait-task>
        </div>
    </div>
</template>

<script>
    import QcMenu from '@/components/SomeMenu/QcMenu'
    import MineTask from './MineTask/index'
    import WaitTask from './WaitTask/index'
    export default {
        data(){
            return{
                showNav: 1,
            }
        },
        methods: {
            getShow(msg){ 
                this.showNav = msg
            }
        },
        components: {
            QcMenu,
            MineTask,
            WaitTask,
        }
    }
</script>