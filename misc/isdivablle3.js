//��ʹ�ó�����ģ�������һ�����Ƿ�������

// �����ַ��������  "121" =>4
function sumofA(a) {
	sum = 0;
	for (var i = 0; i < a.length; i++) {
		sum += parseInt(a[i])
	}

	return sum
}

function isd(n) {
	if (n < 10) {
		if (n == 3 || n == 6 || n == 9)
			return true else
				return false
	} else {
		return isd(
			sumofA(
				(n + '').split('')))
	}
}
isd(20)
isd(21)
isd(210)
//��ʼgoogle��һ����Ŀ,������Сѧ֪ʶ�����Ҳ��һ�����ϵ�ϰ��