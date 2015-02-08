
$(document).ready(function() {
    $("#myform").validate({
    	rules : {
             dateFrom: {
                required: true
             },
             dateTo: {
                 required: true
              },
              nanjiEtc: {
                  required: true,
                  digits: true,
                  minlength: 1,
                  maxlength: 1
               },
               testSyuEtc: {
                   required: true,
                   maxlength: 10
                },
               ippanKamokuEtc: {
                   required: true,
                   maxlength: 10
                },
                senmonKamokuEtc: {
                    required: true,
                    maxlength: 10
                 },
                 kensaSyuEtc: {
                     required: true,
                     maxlength: 10
                  },
                  menkatatiEtc:{
                	  required: true,
                      maxlength: 10
                  },
                  nanji :{
                	  required: true
                  },
                  testSyu :{
                  	  required: true
                    },
                  ippanTime:{
                	  digits: true,
                      maxlength: 3
                  },
                    senmonTime:{
                	  digits: true,
                      maxlength: 3
                  },
                  sonota:{
                      maxlength: 50
                  },
                  sonoTime:{
                	  digits: true,
                      maxlength: 3
                  },
                  sikenComment:{
                      maxlength: 500
                  },
                  theme:{
                      maxlength: 50
                  },
                  bunTime:{
                	  digits: true,
                      maxlength: 3
                  },
                  bunRyo:{
                	  digits: true,
                      maxlength: 4
                  },
                  kanseido:{
                	  digits: true,
                      maxlength: 3
                  },
                  kensaTime:{
                	  digits: true,
                      maxlength: 3
                  },
                  kensaComment:{
                	  digits: true,
                      maxlength: 3
                  },
                  menNin1:{
                	  digits: true,
                      maxlength: 3
                  },
                  menNin2:{
                	  digits: true,
                      maxlength: 3
                  },
                  menTime:{
                	  digits: true,
                      maxlength: 3
                  },
                  sitsuComment:{
                      maxlength: 500
                  },
                  hanseiComment:{
                      maxlength: 500
                  },
                  kenComment:{
                      maxlength: 500
                  },
                  jogen:{
                      maxlength: 500
                  }

      },
      messages: {

         dateFrom: "必須項目です。",
         dateTo: "必須項目です。",
         nanjiEtc: {
             required: "その他を入力してください。",
             digits: "数値で入力して下さい。",
             minlength: "数字一桁で入力してください。",
             maxlength: "数字一桁で入力してください。"
           },
           testSyuEtc: {
               required: "その他を入力してください。",
               maxlength: "10文字以下で入力してください。"
            },
            ippanKamokuEtc: {
                required: "その他を入力してください。",
                maxlength: "10文字以下で入力してください。"
            },
            senmonKamokuEtc:{
                required: "その他を入力してください。",
                maxlength: "10文字以下で入力してください。"
            },
            kensaSyuEtc:{
                required: "その他を入力してください。",
                maxlength: "10文字以下で入力してください。"
            },
            menkatatiEtc:{
                required: "その他を入力してください。",
                maxlength: "10文字以下で入力してください。"
            },
            nanji :{
          	  required: "必須項目です。"
            },
            testSyu :{
          	  required: "必須項目です。"
            },
            ippanTime: {
                digits: "数値で入力して下さい。",
                maxlength: "数字3桁以下で入力してください。"
              },
            senmonTime: {
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            sonota: {
            	maxlength: "50文字以下で入力してください。"
            },
            sonoTime: {
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            sikenComment: {
            	maxlength: "500文字以下で入力してください。"
            },
            theme : {
            	maxlength: "50文字以下で入力してください。"
            },
            bunTime: {
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            bunRyo :{
		        digits: "数値で入力して下さい。",
		        maxlength: "数字4桁以下で入力してください。"
            },
            kanseido:{
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            kensaTime:{
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            kensaComment: {
            	maxlength: "500文字以下で入力してください。"
            },
            menNin1:{
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            menNin2:{
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            menTime:{
		        digits: "数値で入力して下さい。",
		        maxlength: "数字3桁以下で入力してください。"
            },
            sitsuComment: {
            	maxlength: "500文字以下で入力してください。"
            },
            hanseiComment :{
            	maxlength: "500文字以下で入力してください。"
            },
            kenComment :{
            	maxlength: "500文字以下で入力してください。"
            },
            jogen:{
            	maxlength: "500文字以下で入力してください。"
            }



       },
       //表示位置指定
       errorPlacement: function(error, element) {
         switch(element.attr('name')) {
           case "nanji":
             error.insertAfter($('#nanji_error'));
             break;
           case "testSyu":
               error.insertAfter($('#testSyu_error'));
               break;
           default:
             error.insertAfter(element);
         }
       }
    });
});

