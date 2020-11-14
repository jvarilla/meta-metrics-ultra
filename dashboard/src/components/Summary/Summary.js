import React, { Component} from 'react';
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
            var info = 0;
            if(v==2){
              info = <b><Rating r1={0} r2={this.props.metricsData.summary[k] * 5} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; The number of lines in the code are counted and based on the number of lines the cost is calculated.</b>;
            }else if(v == 3){
                info = <b><Rating r1={0} r2={this.props.metricsData.summary[k] * 2} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; A moderate value indicates scope for reuse and high values may indicate an inappropriate abstraction in the design.</b>;
            }else if(v == 4){
                info = <b><Rating r1={0} r2={this.props.metricsData.summary[k] * 2} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; A moderate value indicates scope for reuse and high values may indicate an inappropriate abstraction in the design. Moderate Values are better.</b>;
            }else if(v == 5){
                info = <b><Rating r1={0} r2={this.props.metricsData.summary[k] * 2} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; A moderate value indicates scope for reuse and high values may indicate an inappropriate abstraction in the design. Moderate Values are better.</b>;
            }else if(v == 6){
                info = <b><Rating r1={0} r2={10} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; The deeper a class is in the hierarchy, the higher the degree of methods inheritance, making it more complex to predict its behavior. Good values are between 0 and 4.</b>;
            }else if(v == 7){
                info = <b><Rating r1={0} r2={this.props.metricsData.summary[k]} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; The number of methods and complexity of methods involved is a direct predictor of how much time and effort is required to develop and maintain the class. Smaller values are better.</b>;
            }else if(v == 8){
                info = <b><Rating r1={0} r2={50} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; A moderate value indicates scope for reuse and high values may indicate an inappropriate abstraction in the design. Moderate values are better.</b>;
            }else if(v == 9){
                info = <b><Rating r1={0} r2={50} oneNum={true} num={this.props.metricsData.summary[k]} />&nbsp; This measures the complexity of the class in terms of method calls. It is calculated by adding the number of methods in the class (not including inherited methods) plus the number of distinct method calls made by the methods in the class.</b>;
            }

                if(v == 0){
                   return(
                    <div className="col-lg-6 col-md-6 col-sm-12" key={v}>
                    <div className="alert alert-secondary" role="alert">
                         <h2>{k}</h2>
                         <p className="text-center">This is the path to the src files</p>
                         <p className="text-center"><FontAwesomeIcon icon="file-alt" />&nbsp;{this.props.metricsData.summary.pathToSrc}</p>
                    </div>
                   </div>
         );
        }else if(v == 1){
                   return( 
                 <div className="col-lg-6 col-md-6 col-sm-12" key={v}>
                    <div className="alert alert-secondary" role="alert">
                         <h2>{k}</h2>
                         <p className="text-center">This is the path to the bin files</p>
                         <p className="text-center"><FontAwesomeIcon icon="file-alt" />&nbsp;{this.props.metricsData.summary.pathToBin}</p>
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
                  <div className="col-lg-4 col-md-4 col-sm-12" key={v}>
                <div className="card">
                <div className="card-body">
                    <div className="myContainerPieChart">
                        <PieCharts title={k} dataForChart={chartData}/>
                    </div>
                    <div className="mt-4 text-center">
                      {info}
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

