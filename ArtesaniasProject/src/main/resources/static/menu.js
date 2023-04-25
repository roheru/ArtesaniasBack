/*$(document).ready(function() {
                $('ul li:has(ul)').hover(function(e) {
                        $(this).find('ul').css({display: "block"});
                 },
                function(e) {
                        $(this).find('ul').css({display: "none"});
                });
        });

*/
$(document).ready(function() {
				$("#employeeTable").DataTable({
						'aoColumnDefs': [{
        				'bSortable': false,
        				'aTargets': [-1] /* 1st one, start by the right */
    				}]
				});
			})