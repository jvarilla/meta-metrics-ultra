import React, { Component } from 'react';
import './Summary.css';
import PieCharts from '../PieCharts/PieCharts';
import LargeTitle from '../LargeTitle/LargeTitle';
import BarCharts from '../BarCharts/BarCharts';
import PathText from '../PathText/PathText';

const charTypes = ["none", "pie", "bar"];

class Summary extends Component{

	render(){
		return  Object.keys(this.props.metricsData.summary).map((k,v) => {

                if(v == 0){
                    console.log();
                   return( <div className="col-lg-4 col-md-6 col-sm-12" key={v}>
                <div className="card">
                <div className="card-body">
                    <div>
                        <h2>{k}</h2>
                        <PathText text={this.props.metricsData.summary.pathToSrc}/>
                    </div>
                </div>
            </div>
         </div>
         );
        }else if(v == 1){
                    console.log();
                   return( <div className="col-lg-4 col-md-6 col-sm-12" key={v}>
                <div className="card">
                <div className="card-body">
                    <div>
                        <h2>{k}</h2>
                        <PathText text={this.props.metricsData.summary.pathToBin}/> 
                    </div>
                </div>
            </div>
         </div>
         );
                }else{
                    const chartData = [
                        {name: k +" - "+parseFloat(this.props.metricsData.summary[k].toFixed(2)), value: parseFloat(this.props.metricsData.summary[k].toFixed(3))},
                        {name: "Initial", value: 1}
                    ];
                    console.log();
                    return(
                  <div className="col-lg-4 col-md-6 col-sm-12" key={v}>
                <div className="card">
                <div className="card-body">
                    <div>
                        <PieCharts title={k} dataForChart={chartData}/>
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

