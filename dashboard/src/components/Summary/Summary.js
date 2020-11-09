import React, { Component } from 'react';
import './Summary.css';
import metricsData from '../../metricsData';
import PieCharts from '../PieCharts/PieCharts';

class Summary extends Component{
	render(){
		return  Object.keys(metricsData.summary).map((k,v) => {
                return(
                  <div class="col-lg-4 col-md-6 col-sm-12" key={v}>
                <div class="card">
                <div class="card-body">
                    <div>
                        <PieCharts title={k} />
                    </div>
                </div>
            </div>
         </div>
                )
            })
	}
}

export default Summary;

