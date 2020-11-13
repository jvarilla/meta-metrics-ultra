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
                return {name: k, value: 1};
            });

            // wmc
            const wmc = Object.keys(metrics.wmc.numberOfMethods).map((k,v) => {
                 return {name: k +" - "+metrics.wmc.numberOfMethods[k], value: metrics.wmc.numberOfMethods[k]};
            });

            //num of fields
            const nof = Object.keys(metrics.numFields).map((k,v) => {
                 return {name: k +" - "+metrics.numFields[k], value: metrics.numFields[k]};
            });

            // rfc
            const rfc = Object.keys(metrics.rfc).map((k,v) => {
                 return {name: k +" - "+metrics.rfc[k], value: metrics.rfc[k]};
            });

            // interfaces
            const ifc = Object.keys(metrics.interfaces).map((k,v) => {
                 return {name: k +" - "+metrics.interfaces[k], value: metrics.interfaces[k] + 0.0001};
            });

            return (
                <div>  
                   <div className="container-fluid">
               <div className="row">
                  <div className="left-menu col-md-3 col-xl-3 col-sm-12 col-xs-12 bd-sidebar2 d-none d-sm-none d-md-block d-lg-block d-xl-block">
                    <MetricsAll metricsData={this.props.metricsData}/>
                  </div>
                  <div className="col-sm-12 com-xs-12 d-xs-block d-sm-block d-md-none d-lg-none d-xl-none">
                    <MobileMetricsMenu metricsData={this.props.metricsData} />
                  </div>
                  <div className="metrics-summary col-xl-9 col-md-9 col-sm-12 col-xs-12">
                   <LargeTitle name={this.props.classMetrics.className}/>
                   <Texts text="Here are the individual metrics for each class below. Feedback is available below for each metric on the classes available."/>
                   <div className="row">
                   <div className="col-lg-4 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>DIT (Depth of Inheritance)</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <Texts text={"DIT Value: "+metrics.dit.value}/>
                                    <b><Rating list={ancestors} r1={0} r2={4} num={metrics.dit.value} />&nbsp; Feedback</b>
                                    <p>The Depth of inheritance measures the maximum number of steps from the class node to the root of the inheritance.</p>
                                </div>
                                
                                <PieCharts title="Ancestors" dataForChart={ancestors}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-4 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                            <h2>WMC</h2>
                                <div className="alert alert-secondary" role="alert">
                                    <Texts text={"WMC Value: "+metrics.wmc.value}/>
                                    <Texts text={"# of Constructors: "+metrics.wmc.numberOfConstructors}/>
                                </div>
                                
                                <SimplePieChart title="Number of Methods" metricsData={wmc}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-4 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                                <SimplePieChart title="Number of Fields" metricsData={nof}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-4 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                                <SimplePieChart title="RFC" metricsData={rfc}/>
                             </div>
                            </div>
                        </div>
                   </div>

                   <div className="col-lg-4 col-md-6 col-sm-12">
                    <div className="card">
                        <div className="card-body">
                            <div>
                                <PieCharts title="Interfaces" dataForChart={ifc}/>
                             </div>
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