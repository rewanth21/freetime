$(function(){
  var $orders = $('#orders'),
      $name = $('#name'),
      $drink = $('#drink');
  
  $.ajax({
    type: 'GET',
    url: 'http://rest.learncode.academy/api/henrik/orders',
    success: function(data){
      $.each(data, function(i, item){
        $orders.append('<li>Name:'+item.name+', age'+item.drink+'</li>')
      });
    },
    error: function(){
      alert: 'Something went wrong!';
    }
  });
  
  $('#add-order').on('click', function(){
    
    var order = {
      name: $name.val(),
      drink: $drink.val()
    };
    
     $.ajax({
      type: 'POST',
      url: 'http://rest.learncode.academy/api/henrik/orders',
      data: order,
      success: function(newOrder){
        $orders.append('<li>Name:'+newOrder.name+', drink:'+newOrder.drink+'</li>');
      }
    });

  });
});