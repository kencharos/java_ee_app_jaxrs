/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var vm = new Vue({
    el: '#app',
    data :{idError:null, passwordError:null, id:"", password:"", user:sessionStorage.user},
    methods : {
        login : function(e){
            e.preventDefault();
            var $data = this.$data;
            $data.idError = null;
            $data.passwordError = null;
            $.ajax({url:"rest/login", 
                    data:JSON.stringify({"id":$data.id, "password":$data.password}),
                    method:"POST", contentType: 'application/json'}
            ).success(function(data){
                sessionStorage.setItem("user", data.user);
                location.href = data.next;
                
            }).fail(function(xhr, status){
                if (xhr.status !== 400) {
                    alert(status);
                    return;
                }
                var error = xhr.responseJSON;
                var getMessage = function(key) {
                    var list = error.filter(function(e){return e.key === key;});
                    return list.length > 0 ? list[0].message : null;
                };
                $data.idError = getMessage("id");
                $data.passwordError = getMessage("password");
                console.log($data)
            });
        }
    }
});
            

