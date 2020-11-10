import React, { Component } from 'react';
import './Summary.css';
import PieCharts from '../PieCharts/PieCharts';
import LargeTitle from '../LargeTitle/LargeTitle';
import BarCharts from '../BarCharts/BarCharts';

const charTypes = ["none", "pie", "bar"];

class Summary extends Component{
	render(){
		return  Object.keys(this.props.metricsData.summary).map((k,v) => {
                if(v == 2 || v == 4){
                   return( <div className="col-lg-4 col-md-6 col-sm-12" key={v}>
                <div className="card">
                <div className="card-body">
                    <div>
                        <BarCharts title={k}/>
                    </div>
                </div>
            </div>
         </div>
         );
                }else{
                    return(
                  <div className="col-lg-4 col-md-6 col-sm-12" key={v}>
                <div className="card">
                <div className="card-body">
                    <div>
                        <PieCharts title={k} />
                    </div>
                </div>
            </div>
         </div>
                )
                }
            })
	}
}

export default Summary;

