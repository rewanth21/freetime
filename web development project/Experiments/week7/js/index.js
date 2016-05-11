window.onload = function(){
  resize();
}
window.onresize = function(){
  resize();
}

function image(p, prevC){
  var c = document.createElement('canvas'),
      $ = c.getContext('2d');
  
  c.width = p.offsetWidth;
  c.height = p.offsetHeight;
  
  $.globalCompositeOperation = 'xor';
  $.fillStyle = p.dataset.color;
  $.fillRect(0, 0, c.width, c.height);
  
  $.font = '100px Nunito, sans-serif';
  $.textAlign = 'center';
  $.fillText(p.textContent, c.width / 2, c.height / 2, c.width);
  if (prevC){
    $.globalCompositeOperation = 'destination-over';
    $.drawImage(prevC, 0, 0);
  }
  
  return c;
}
function resize(){
   var w = c.clientWidth;
   var h = c.clientHeight;
   if (c.width != w ||
       c.height != h) {
     c.width = w;
     c.height = h;
   }
}
var p = document.getElementsByClassName('page');

var c, s;
for(var i=0, len=p.length; i<len; i++){
  c = image(p[i], c);
  s = ['background: transparent url(', ') no-repeat fixed;'].join(c.toDataURL('image/png'));
  p[i].setAttribute('style', s);
}
