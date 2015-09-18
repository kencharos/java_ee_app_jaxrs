
var vm = new Vue({
    el: '#app',
    data:{user:sessionStorage.user, notifications:[]},
    created : function(){
        var $data = this.$data;
        $data.idError = null;
        $data.passwordError = null;
        $.ajax({url:"rest/notifications", method:"GET"}
        ).success(function(data){
            $data.notifications = data.list;
        });
    }
});
            

