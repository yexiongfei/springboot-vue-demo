<template>
    <div class="hello">Hello {{who}}</div>
</template>

<script>
    module.exports = {
        data: function() {
            return {
                who: 'component1'
            }
        },
        mounted() {
            console.log('-------component1-----------')
        }
    }
</script>
