// Heart class
function Heart(x,y,r,vx,vy)
{
  this.x = x;
  this.y = y;
  this.r = r;
  this.vx = vx;
  this.vy = vy;

  // Has this heart been hit by another heart?
  this.isHit = false;

  // Is this heart currently inside the barrier?
  this.inBarrier = false;

  // render the heart
  this.render = function(context) {

    // TODO implement this method. Should render a different color depending on whether the ball has been hit.
	if(this.isHit)
	{
		context.beginPath();
		
		context.moveTo(this.x,this.y);
		context.bezierCurveTo(this.x+this.r,this.y-this.r,this.x+this.r,this.y,this.x,this.y+this.r);
		context.moveTo(this.x,this.y);
		context.bezierCurveTo(this.x-this.r,this.y-this.r,this.x-this.r,this.y,this.x,this.y+this.r);
		context.fillStyle='red';
		context.fill();
		
		context.closePath();
			
	}
	else
	{
		context.beginPath();
		
		context.moveTo(this.x,this.y);
		context.bezierCurveTo(this.x+2*this.r,this.y-2*this.r,this.x+2*this.r,this.y,this.x,this.y+this.r);
		context.moveTo(this.x,this.y);
		context.bezierCurveTo(this.x-2*this.r,this.y-2*this.r,this.x-2*this.r,this.y,this.x,this.y+this.r);
		context.fillStyle='green';
		context.fill();
		
		context.closePath()
		
	}

  // render

	

  } // move
  
  
  // Move the heart - should slow down when in barrier and handle collisions with walls
  this.move = function(canvas) {
	
    if (this.inBarrier == false)
    {
      this.x = this.x + this.vx;
      this.y = this.y + this.vy;
    }
    else {

      this.x = this.x + this.vx/4;
      this.y = this.y + this.vy/4;
    }

    this.collideWalls(canvas);
	
	
	}

  // Handle collisions with walls - this will be called in move()
  this.collideWalls = function(canvas) {
	
    // TODO implement this method. Heart should bounce off wall at same angle it struck wall
	//(x1 <= x <= x2) and (y1 <= y <= y2)
	/**
	if(context.isPointInPath(x,y,))
	{
		this.vx*=-1;
	}
	else{
		this.vx*=-1;
		
	}
	*/

	if(this.x+this.vx<0)
	{
		this.vx*=-1;
	}
	if(this.x+this.vx>canvas.width)
	{
		this.vx*=-1;
	}
	
	if(this.y+this.vy<0)
	{
		this.vy*=-1;
	}
	if(this.y+this.vy>canvas.height)
	{
		this.vy*=-1;
	}
	
  }

  // This function registers a hit on this heart and updates global number of hearts hit
  this.hit = function(){

    if(this.isHit == false)
    {
      numHit++;
    }
    this.isHit = true;
  }
}
