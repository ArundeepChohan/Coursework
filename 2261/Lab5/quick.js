<!--

var editing  = false;

if (document.getElementById && document.createElement) {
	var butt = document.createElement('BUTTON');
	var buttext = document.createTextNode('Ready!');
	butt.appendChild(buttext);
	butt.onclick = saveEdit;
}

function catchIt(e) {
	if (editing) return;
	if (!document.getElementById || !document.createElement) return;
	if (!e) var obj = window.event.srcElement;
	else var obj = e.target;
	while (obj.nodeType != 1) {
		obj = obj.parentNode;
	}
	if (obj.tagName == 'TEXTAREA' || obj.tagName == 'A') return;
	while (obj.nodeName != 'P' && obj.nodeName != 'HTML') {
		obj = obj.parentNode;
	}
	if (obj.nodeName == 'HTML') return;
	var x = obj.innerHTML;
	var y = document.createElement('TEXTAREA');
//	y.appendChild(document.createTextNode(x));
	var z = obj.parentNode;
	z.insertBefore(y,obj);
	z.insertBefore(butt,obj);
	z.removeChild(obj);
	y.value = x;
	y.focus();
	editing = true;
	return false;
}

function saveEdit() {
	var area = document.getElementsByTagName('TEXTAREA')[0];
	var y = document.createElement('P');
	var z = area.parentNode;
	y.innerHTML = area.value;
	z.insertBefore(y,area);
	z.removeChild(area);
	z.removeChild(document.getElementsByTagName('button')[0]);
	editing = false;
	return false;
}


document.onclick = catchIt;
