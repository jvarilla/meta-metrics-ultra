import React, { Component } from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { fas } from "@fortawesome/free-solid-svg-icons";
import './MobileMetricsMenu.css';

class MobileMetricsMenu extends Component{
   render(){
      return(
      	<div>
        <div className="fixed-bottom">
		  <div class="btn-group dropup dropupArea">
  			<a role="button" id="mobileButton" class="btn btn-default btn-lg btn-block dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    			View All Metrics
  			</a>
  			<div class="dropdown-menu mobileDropdownMenu">
				{this.props.metricsData.classes.map((v, i) => 
						<a href={"/metrics/classes/"+i} key={"class"+i} className="dropdown-item">{v.className}</a>
				)}
  			</div>
  			</div>
        </div>
      	</div>

      	);

   }
}

export default MobileMetricsMenu;