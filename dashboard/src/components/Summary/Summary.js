import React, { Component } from 'react';
import './Summary.css';
import PieCharts from '../PieCharts/PieCharts';
import LargeTitle from '../LargeTitle/LargeTitle';
import BarCharts from '../BarCharts/BarCharts';
import PathText from '../PathText/PathText';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import Rating from '../Rating/Rating';

const charTypes = ["none", "pie", "bar"];

class Summary extends Component{

	render(){
		return  Object.keys(this.props.metricsData.summary).map((k,v) => {

                if(v == 0){
                    console.log();
                   return(
                    <div className="col-lg-6 col-md-6 col-sm-12" key={v}>
                    <div className="alert alert-secondary" role="alert">
                         <h2>{k}</h2>
                         <p className="text-center">This is the path to the src files</p>
                         <p><FontAwesomeIcon icon="file-alt" />&nbsp;{this.props.metricsData.summary.pathToSrc}</p>
                    </div>
                   </div>
         );
        }else if(v == 1){
                   return( 
                 <div className="col-lg-6 col-md-6 col-sm-12" key={v}>
                    <div className="alert alert-secondary" role="alert">
                         <h2>{k}</h2>
                         <p className="text-center">This is the path to the bin files</p>
                         <p><FontAwesomeIcon icon="file-alt" />&nbsp;{this.props.metricsData.summary.pathToBin}</p>
                    </div>
                   </div>
         );
                }else{
                    var test = (parseFloat(this.props.metricsData.summary[k]) == 0) ? 0.001 : parseFloat(this.props.metricsData.summary[k]);
                    const chartData = [
                        {name: k +" - "+parseFloat(this.props.metricsData.summary[k].toFixed(2)), value: parseFloat(test.toFixed(2))},
                        {name: "Init", value: 1}
                    ];
                    return(
                  <div className="col-lg-6 col-md-6 col-sm-12" key={v}>
                <div className="card">
                <div className="card-body">
                    <div className="myContainerPieChart">
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

