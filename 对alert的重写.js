	window.alert = function (str,ok_func, flag) {
		if (flag == null) {
			flag = 0;
		}	
//		str=toString(str) //�Լ�ʵ�ֵķ���  ���Ͳ�ȫ��
//		function toString (str){
//			if(typeof str==="string")
//			return  "'"+str+"'";
//			if(typeof str==="number")
//				return  str;
//		         �����������͵�  ������
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
//		str=JSON.stringify(str) // ie �»���������
		var answerStr = JSON.stringify(str);  
		var o = JSON.parse( answerStr);
		eval("var answerStr = '"+JSON.stringify(o)+"';"); 
		str=answerStr;
		if(!BrowserDetect.isIE()){
		 	return __alert(str);
		 }
		return showModalDialog(URL_ALERT, new Array(flag + "", str), "dialogWidth=500px;dialogHeight=200px;resizable=yes;status=no;help=no");
	};

var o={a:"A",b:"B",o:{tips:"����0",UPPER:"O"},'YI':1};
//o="st11111111111"
alert(o);

