<template>
    <div class="RunPage">
        <RunMenu @showFun='getShow'></RunMenu>
        <div class="RunPageBody">
            <WaitProduct v-if="showNav==1"></WaitProduct>
            <Planned v-else-if="showNav==2"></Planned>
            <InProduction v-else-if="showNav==3"></InProduction>
        </div>
    </div>
</template>

<script>
    import RunMenu from '@/components/SomeMenu/RunMenu'
    import WaitProduct from './WaitProduct/index'
    import Planned from './Planned/index'
    import InProduction from './InProduction/index'
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
            RunMenu,
            WaitProduct,
            Planned,
            InProduction
        }
    }
</script>