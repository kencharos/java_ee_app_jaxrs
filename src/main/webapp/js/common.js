// Vue js 共通コンポーネント

var AppHeader = Vue.extend({
    props : ["user"],
    template: '<nav class="navbar navbar-inverse">'
            +'<div class="container">'
                +'<div class="navbar-header">'
                    +'<a class="navbar-brand" href="login.html">Java EE JAX-RS sample</a>'
                +'</div>'
                 + '<div class="navbar-form navbar-right" v-if="user" >'
                    +'<input type="button" value="logout"  class="btn btn-default" onclick="logout()"/>'
                 +'</div>'
            +'</div>'
        +'</nav>'
});



var AppFooter = Vue.extend({
    template: '<footer class="footer">'
           +'<div class="container">'
                +'<p class="text-muted text-right">2015</p>'
           +'</div>'
        +'</footer>'
});

var BootstrapFormControl = Vue.extend({ 
    props : ["label", "name", "error"],
    template : '<div class="form-group {{error ? \'has-error\' : \'\'}}">'
                   +'<label for="{{name}}" class="control-label" >{{label}} {{error}}</label>'
                   +'<content>inputタグ想定</content>'
               +'</div>'
});

// コンポーネントを登録
Vue.component('bs-fc', BootstrapFormControl);
Vue.component('app-header', AppHeader);
Vue.component('app-footer', AppFooter);

function logout(){
    delete sessionStorage.user;
    location.href ="rest/logout";
}