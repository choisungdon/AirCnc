function viewMenu(){
    var drop_menu = document.querySelector('.drop_menu');

    if(drop_menu.style.display != 'block'){
        drop_menu.style.display= 'block';
    }else{
        drop_menu.style.display = 'none';
    }
}

function rsvChange(i_reser){
	location.href = '/reservation/rsvChange?i_reser='+i_reser;
}

function cancel(i_reser){
	location.href = '/reservation/rsvCancel?i_reser='+i_reser;
}