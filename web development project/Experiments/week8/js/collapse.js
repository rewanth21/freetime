$(document).ready(function(){
  var DELAY = 20,	// used to distinguish click v dbl click
      clicks = 0,
      timer = null,
      t = null;
  $("p").slideUp();
  
  $(".solar").on("click", function(e){

        clicks++;  //count clicks

        if(clicks === 1) {
          t = this;
          timer = setTimeout(function(){
              if($('p',t).is(":hidden")){
                $('p').slideUp();       //perform single-click action
                $('p',t).slideDown();
              }
              clicks = 0;               //after action performed, reset counter
            }, DELAY);
        } else {
          clearTimeout(timer);    //prevent single-click action
          if($('p').is(":visible")){
            $('p').slideUp();     //perform double-click action
          } else {
            $('p').slideDown();    //perform double-click action
          }
          clicks = 0;             //after action performed, reset counter
        }
    })
    .on("dblclick", function(e){
        e.preventDefault();  //cancel system double-click event
    });
});