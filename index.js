// import React from 'react';
// if (__DEV__) {
//   const whyDidYouRender = require('@welldone-software/why-did-you-render');
//   whyDidYouRender(React, {
//     trackAllPureComponents: true,
//   });
// }

import 'react-native-reanimated';
import 'react-native-gesture-handler';

// import {onAppBeginLaunch} from './src/launch-profiler';

// onAppBeginLaunch();

import {AppRegistry, NativeModules} from 'react-native';
// import 'react-native-gesture-handler';
// import 'react-native-url-polyfill/auto';
import {name as appName} from './app.json';
import {PayInEmiButton as App} from './PayInEmi';
// import './src/utils/notifications';

// NativeModules.RNAppReady.ready();

AppRegistry.registerComponent(appName, () => App);
