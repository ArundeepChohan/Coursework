// Barrier class
function Barrier(x,y,r) {
  // TODO implement this class
this.x=x;
this.y=y;
this.r=r;
/*
Properties:
x: horizontal position
y: vertical position
r: radius
Methods:
move()
render()
*/
this.move = function() {
	this.x=mouseX;
	this.y=mouseY;
	
}
this.render = function(context) {
	context.beginPath();
	context.fillStyle='blue';
	context.arc(this.x,this.y,this.r,0,2*Math.PI)
	context.fill();
	context.closePath();
	
}


  
}
