function supporthHtml5() {
    return (typeof(Worker) !== "undefined") ? true : false;
}

function addfavorite(theUrl) {
    if (document.all) {
        window.external.addFavorite(theUrl, 'Emerson Web Order'); 
    }
    else if (window.sidebar) {
        window.sidebar.addPanel('Emerson Web Order', theUrl, ''); 
    }
} 

$(document).ready(function() {
    jQuery.ajaxSetup({cache:false});
});

//select all items
function selectAll() {
    var aChecked = $(".select_all").prop("checked");
    if (typeof(aChecked) == "undefined") {aChecked = false;}
    $(".selectable").each(function() {
        if (typeof($(this).attr("disabled")) == "undefined") {
            var subchecked = $(this).prop("checked");
            if (subchecked != aChecked) {
                $(this).prop("checked", aChecked);
            }
        }
    });
}

function EnsureDecimal(e) {
    e.value = e.value.replace(/[^\d.]/g,""); //先把非数字的都替换掉，除了数字和.
    e.value = e.value.replace(/^\./g,""); //必须保证第一个为数字而不是.
    e.value = e.value.replace(/\.{2,}/g,"."); //保证只有出现一个.而没有多个.
    e.value = e.value.replace(".","$#$").replace(/\./g,"").replace("$#$","."); //保证.只出现一次，而不能出现两次以上
}

function EnsureInt() {
    if (((event.keyCode < 48) || (event.keyCode > 57))) {
       event.returnValue = false;
    }
}

/*********************HTML5 Notification Functions **************************************/

/** 
 * 金额按千位逗号分割 
 * @character_set UTF-8 
 * @author Jerry.li(hzjerry@gmail.com) 
 * @version 1.2014.08.24.2143 
 *  Example 
 *  <code> 
 *      alert($.formatMoney(1234.345, 2)); //=>1,234.35 
 *      alert($.formatMoney(-1234.345, 2)); //=>-1,234.35 
 *      alert($.unformatMoney(1,234.345)); //=>1234.35 
 *      alert($.unformatMoney(-1,234.345)); //=>-1234.35 
 *  </code> 
 */  
!(function($)  
		{  
		    $.extend({  
		        /** 
		         * 数字千分位格式化 
		         * @public 
		         * @param mixed mVal 数值 
		         * @param int iAccuracy 小数位精度(默认为2) 
		         * @return string 
		         */  
		        formatMoney:function(mVal, iAccuracy){  
		            var fTmp = 0.00;//临时变量  
		            var iFra = 0;//小数部分  
		            var iInt = 0;//整数部分  
		            var aBuf = new Array(); //输出缓存  
		            var bPositive = true; //保存正负值标记(true:正数)  
		            /** 
		             * 输出定长字符串，不够补0 
		             * <li>闭包函数</li> 
		             * @param int iVal 值 
		             * @param int iLen 输出的长度 
		             */  
		            function funZero(iVal, iLen){  
		                var sTmp = iVal.toString();  
		                var sBuf = new Array();  
		                for(var i=0,iLoop=iLen-sTmp.length; i<iLoop; i++)  
		                    sBuf.push('0');  
		                sBuf.push(sTmp);  
		                return sBuf.join('');  
		            };  
		  
		            if (typeof(iAccuracy) === 'undefined')  
		                iAccuracy = 2;  
		            bPositive = (mVal >= 0);//取出正负号  
		            fTmp = (isNaN(fTmp = parseFloat(mVal))) ? 0 : Math.abs(fTmp);//强制转换为绝对值数浮点  
		            //所有内容用正数规则处理  
		            iInt = parseInt(fTmp); //分离整数部分  
		            iFra = parseInt((fTmp - iInt) * Math.pow(10,iAccuracy) + 0.5); //分离小数部分(四舍五入)  
		  
		            do{  
		                aBuf.unshift(funZero(iInt % 1000, 3));  
		            }while((iInt = parseInt(iInt/1000)));  
		            aBuf[0] = parseInt(aBuf[0]).toString();//最高段区去掉前导0  
		            return ((bPositive)?'':'-') + aBuf.join(',') +'.'+ ((0 === iFra)?'00':funZero(iFra, iAccuracy));  
		        },  
		        /** 
		         * 将千分位格式的数字字符串转换为浮点数 
		         * @public 
		         * @param string sVal 数值字符串 
		         * @return float 
		         */  
		        unformatMoney:function(sVal){  
		            var fTmp = parseFloat(sVal.replace(/,/g, ''));  
		            return (isNaN(fTmp) ? 0 : fTmp);  
		        },  
		    });  
		})(jQuery);
		///////////////////////////////////////////////////////

		$(document).ready(function() {
        $("#new_address_dialog").on("show.bs.modal", function (e) {
            loadPage("new_address_content_div", "<?php echo $this->baseUrl . '/system/address/add.ajax/cid/' . $this->customerId . '/from/' . base64_encode($_SERVER['REQUEST_URI']); ?>");
        });

        $("#new_address_dialog").on("hidden.bs.modal", function (e) {
            $(this).removeData("bs.modal");
        });

        $("#new_address_button").click(function() {
            $.ajax({
                url: "<?php echo $this->baseUrl . '/system/address/save.ajax' ?>",
                type: 'POST',
                data: {"customer":$('#customer').val(),"address":$('#address').val(),"zip_code":$('#zip_code').val(),"telephone":$('#telephone').val(),"cell_phone":$('#cell_phone').val(),"contact_person":$('#contact_person').val(),"province_name":$('#province_name').val(),"city_name":$('#city_name').val(),"area_name":$('#area_name').val(),"is_default":0},
                error: function() { alert("添加收货地址出错!!"); },
                success: function(msg) {
                    //alert(msg);
                    $(".address-list li").removeClass("selected");
                    $(".address-list").append("<li class='selected'><input type='radio' id='addr_0' name='ship_to1' value='' checked /><label for='addr_0'>" + msg + "</label>");
                    $('#ship_to').val(msg);
                    $("#new_address_dialog").modal("hide");
                }
            });
        });

        $(".address-list li :radio").click(function() {
            $(this).parent().parent().addClass("selected").siblings().removeClass("selected");
        });

        $("#rebate").blur(function() { //确保返利的数字有效
            item_qty = parseInt($(this).val());
            if (isNaN(item_qty) || (item_qty == 0)) {
                $(this).val($("#max_rebate").val());
            }
        });

        $("#credit").blur(function() { //确保信用额度的数字有效
            item_qty = parseInt($(this).val());
            if (isNaN(item_qty) || (item_qty == 0)) {
                $(this).val(0);
            }
        });

        $("#new_iris_project_dialog").on("show.bs.modal", function (e) {
            loadPage("new_iris_project_content_div", "<?php echo $this->baseUrl . '/trans/iris/add.ajax/'; ?>");
        });

        $("#new_iris_project_dialog").on("hidden.bs.modal", function (e) {
            $(this).removeData("bs.modal");
        });

        $("#new_iris_project_button").click(function() {
            $.ajax({
                url: "<?php echo $this->baseUrl . '/trans/iris/save.ajax' ?>",
                type: 'POST',
                data: {"db_action":$('#db_action').val(),"customer_id":$('#customer_id').val(),"project_name":$('#project_name').val(),"project_site":$('#project_site').val(),"project_cycle":$('#project_cycle').val(),"project_vendor":$('#project_vendor').val(),"freezing_medium":$('#freezing_medium').val(),"is_valid":$('#is_valid').val()},
                error: function() { alert("添加IRIS项目出错!!"); },
                success: function(msg) {
                    $("#new_iris_project_dialog").modal("hide");
                    location.reload();
                }
            });
        });
    });
    
    function saveAddress() {
        $.ajax({
            type: "post",
            url: "<?php echo $this->baseUrl . '/system/address/save.ajax';?>",
            data: {"customer":$('#customer').val(),"address":$('#address').val(),"zip_code":$('#zip_code').val(),"telephone":$('#telephone').val(),"cell_phone":$('#cell_phone').val(),"contact_person":$('#contact_person').val(),"province_name":$('#province_name').val(),"city_name":$('#city_name').val(),"area_name":$('#area_name').val(),"is_default":0},
            error: function(msg) {alert("Error:" + msg);},
            success: function(msg) {
                $(".address-list li").removeClass("selected");
                $(".address-list").append("<li class='selected'><input type='radio' id='addr_0' name='ship_to1' value='' checked /><label for='addr_0'>" + msg + "</label>");
                $('#ship_to').val(msg);
                closeDiv('new_address_div');
            }
        });
    }

    //数据检查
    function beforePost() {
        if (isValid() == false) return false;
        if (($("#BTB2").prop("checked") == true) && (jQuery.trim($('#BTB_desc').val()) == "")) {
            alert("请注明最终用户名称和最终目的地！");
            return false;
        }
        if ($("#use_rebate").prop("checked") == true) {
            if (parseInt($("#rebate").val()) > parseInt($("#max_rebate").val())) {
                //alert($("#rebate").val());
                //alert($("#max_rebate").val());
                alert("返利使用金额超出最大值");
                $("#rebate").focus();
                return false;
            }
        }
        if ($("#terms").prop("checked") == false) {
            alert("提交订单前，请阅读《艾默生销售条款和条件》");
            return false;
        }
        return true;
    }
