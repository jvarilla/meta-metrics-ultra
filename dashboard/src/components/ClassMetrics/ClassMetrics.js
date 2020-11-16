import React, { Component } from 'react';
import './ClassMetrics.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import MetricsAll from '../MetricsAll/MetricsAll';
import MobileMetricsMenu from '../MobileMetricsMenu/MobileMetricsMenu';
import Breadcrumbs from '../Breadcrumbs/Breadcrumbs';
import LargeTitle from '../LargeTitle/LargeTitle';
import Texts from '../Texts/Texts';
import Summary from '../Summary/Summary';
import PieCharts from '../PieCharts/PieCharts';
import BarCharts from '../BarCharts/BarCharts';
import SimplePieChart from '../SimplePieChart/SimplePieChart';
import Rating from '../Rating/Rating';


class ClassMetrics extends Component {
  
    render() {
        if (this.props.classMetrics) {
            const metrics = this.props.classMetrics;

            // ancestors for DIT
            const ancestors = metrics.dit.ancestors.map((k, v) => {
                return {name: k, value: metrics.dit.value};
            });

            let anc;
            if(metrics.dit.ancestors.length == 0){
              var a = [{name: "Ancestors not found", value: 0.01}]
               anc = <SimplePieChart title="Ancestors" metricsData={a}/>
            }else{
              anc = <SimplePieChart title="Ancestors" metricsData={ancestors}/>
            }

            // wmc
            const wmc = Object.keys(metrics.wmc.numberOfMethods).map((k,v) => {
                  var val = (metrics.wmc.numberOfMethods[k] == 0) ? 0.01 : metrics.wmc.numberOfMethods[k];
                 return {name: k +" - "+metrics.wmc.numberOfMethods[k], value: val};
            });

            //num of fields
            const nof = Object.keys(metrics.numFields).map((k,v) => {
              var val = (metrics.numFields[k] == 0) ? 0.01 : metrics.numFields[k];
                 return {name: k +" - "+metrics.numFields[k], value: val};
            });

            // rfc
            const rfc = Object.keys(metrics.rfc).map((k,v) => {
              var val = (metrics.rfc[k] == 0) ? 0.01 : metrics.rfc[k];
                 return {name: k +" - "+metrics.rfc[k], value: val};
            });

            // interfaces
            const ifc = Object.keys(metrics.interfaces).map((k,v) => {
              var val = (metrics.interfaces[k] == 0) ? 0.01 : metrics.interfaces[k];
                 return {name: k +" - "+metrics.interfaces[k], value: val};
            });

           // let interf;
            //if(metric.interfaces == null)

            return (
                <div className="classMetrics">  
                   <div className="container-fluid">
               <div className="row">
                  <div className="left-menu col-md-2 col-xl-2 col-sm-12 col-xs-12 bd-sidebar2 d-none d-sm-none d-md-block d-lg-block d-xl-block">
                    <MetricsAll metricsData={this.props.metricsData}/>
                  </div>
                  <div className="col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none">
                    <MobileMetricsMenu metricsData={this.props.metricsData} />
                  </div>
                  <div className="metrics-summary col-xl-10 col-md-10 col-sm-12 col-xs-12 mt-2">
                  <nav aria-label="breadcrumb">
                    <ol className="breadcrumb">
                        <li className="breadcrumb-item" aria-current="page"><a href="/dashboard">Back to Summary</a></li>
                    </ol>
                  </nav>
                   <LargeTitle name={"Class: "+this.props.classMetrics.className}/>
                   <p><FontAwesomeIcon icon="info-circle" />&nbsp;Here are the individual metrics for each class below. Feedback is available below for each metric on the classes available.</p>
                   <div className="alert alert-secondary" role="alert">
                         <h5>Metrics Legend</h5>
                         <p><FontAwesomeIcon icon="thumbs-up" /> - Metric meet standards for CK Metrics Recommendations</p>
                         <p><FontAwesomeIcon icon="thumbs-down" /> - DOES NOT Metric meet standards for CK Metrics Recommendations</p>
                    </div>
                   <div className="row">
                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>DIT (Depth of Inheritance)</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={4} oneNum={true} num={metrics.dit.value} />&nbsp; Results for DIT</b>
                                    <p>The Depth of inheritance measures the maximum number of steps from the class node to the root of the inheritance. Your value is {metrics.dit.value}.</p>
                                </div>
                                {anc}
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>WMC (Weighted methods per class)</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={4} oneNum={true} num={metrics.wmc.value} />&nbsp; Results for WMC</b>
                                    <p>WMC measures the complexity of a class. Complexity of a class can for example be calculated by the cyclomatic complexities of its methods. Smaller values are better for WMC. Your value is {metrics.wmc.value} with {metrics.wmc.numberOfConstructors} constructors.</p>
                                </div>
                                
                                <SimplePieChart title="Number of Methods" metricsData={wmc}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                        <h2>NOF (Number of Fields)</h2>
                              <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={4} oneNum={true} num={0} />&nbsp; Results for NOF</b>
                                    <p>The number of fields show the total methods for the class.</p>
                             </div>

                                <SimplePieChart title="NOF Metrics" metricsData={nof}/>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <h2>RFC (Response for a Class)</h2>
                              <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={0} r2={50} oneNum={true} num={metrics.rfc.total} />&nbsp; Results for RFC</b>
                                    <p>RFC is defined as a count of the set of methods that can be potentially executed in response to a message received by an instance of the class. The Total RFC is {metrics.rfc.total}. The RFC value is typically between 0 to 50 depending on the project.</p>
                             </div>
                            <SimplePieChart title="RFC" metricsData={rfc}/>
                             
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-6 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                        <h2>Interfaces for Class</h2>
                              <div className="alert alert-secondary" role="alert">
                                    <b><Rating r1={-1} r2={-1} oneNum={false} num={metrics.interfaces.numberOfInterfacesImplemented} />&nbsp; Results for Class Interfaces</b>
                                    <p>These are the number of interface implementions in the class. If there is not an interface, this means that the dependency inversion principle is not being followed and that the classes are tightly coupled to concrete implementations. This would make the code brittle and hard to change.</p>
                             </div>
                                <SimplePieChart title="Interfaces" metricsData={ifc}/>
                        </div>
                        </div>
                   </div>

                  </div>
                  </div>
               </div>
            </div>
                </div>
            )
        } else {
            return (
                <div>
                    Loading... 
                </div>
            )
        }
    }
}

export default ClassMetrics;