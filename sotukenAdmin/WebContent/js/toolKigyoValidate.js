
$(document).ready(function() {
    $("#myform").validate({
    	rules : {
             kigyoName: {
                required: true,
                maxlength: 100
             },
             kigyoFuri: {
                 required: true,
                 maxlength: 100
              },
              address: {
                  required: true,
                  maxlength: 100
              }
      },
      messages: {

         kigyoName: {
             required: "企業名を入力してください。",
             maxlength: "100文字以内で入力してください。"
          },
           kigyoFuri: {
               required: "ふりがなを入力してください。",
               maxlength: "100文字以内で入力してください。"
           },
            address: {
                 required: "住所を入力してください。",
                 maxlength: "100文字以内で入力してください。"
             }

       }

    });
});

