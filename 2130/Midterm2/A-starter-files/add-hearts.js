function addHearts(canvas,Heart){

  var hearts = [];
  // Distance between hearts
  var dx = canvas.width/Math.sqrt(numHearts);
  var dy = canvas.height/Math.sqrt(numHearts);

  // Create hearts with random velocities
  var y = 1;
  var x = 0;
  for(var i = 0;i<numHearts;i++){

    x++;
    if (x*dx - .9*dx  > canvas.width)
    {
      x=1;
      y++;
    }

    hearts.push(new Heart(
      x*dx -.9*dx,
      y*dy - .9*dy,
      radius,
      2*Math.random()*maxSpeed-maxSpeed,
      2*Math.random()*maxSpeed-maxSpeed
    ));
  }//i

  return hearts;
}
