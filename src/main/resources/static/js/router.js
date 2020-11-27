    const Component1 = httpVueLoader('/view/component1.vue')
    const Component2 = httpVueLoader('/view/component2.vue')

    const routes = [
        {path: '/component1', component: Component1},
        {path: '/component2', component: Component2}
    ]

    const router = new VueRouter({
        routes // (缩写) 相当于 routes: routes
    })