	window.alert = function (str,ok_func, flag) {
		if (flag == null) {
			flag = 0;
		}	
//		str=toString(str) //自己实现的方法  类型不全面
//		function toString (str){
//			if(typeof str==="string")
//			return  "'"+str+"'";
//			if(typeof str==="number")
//				return  str;
//		         继续其他类型的  如数组
//			  var result="";
//			    for (var key in str) {	 
//			    	result += "{"
//					result += key + ":"  ;
//					result += toString(str[key])
//					result += "}";
//			    } 
//			   
//			   return result; 
//		}
//		str=JSON.stringify(str) // ie 下会中文乱码
		var answerStr = JSON.stringify(str);  
		var o = JSON.parse( answerStr);
		eval("var answerStr = '"+JSON.stringify(o)+"';"); 
		str=answerStr;
		if(!BrowserDetect.isIE()){
		 	return __alert(str);
		 }
		return showModalDialog(URL_ALERT, new Array(flag + "", str), "dialogWidth=500px;dialogHeight=200px;resizable=yes;status=no;help=no");
	};

var o={a:"A",b:"B",o:{tips:"不是0",UPPER:"O"},'YI':1};
//o="st11111111111"
alert(o);

