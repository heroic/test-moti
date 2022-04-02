// /**
//  * Metro configuration for React Native
//  * https://github.com/facebook/react-native
//  *
//  * @format
//  */

const {getDefaultConfig} = require('metro-config');

module.exports = (async () => {
  const {
    resolver: {sourceExts, assetExts},
  } = await getDefaultConfig();
  return {
    transformer: {
      babelTransformerPath: require.resolve('react-native-svg-transformer'),
      getTransformOptions: async () => ({
        transform: {
          experimentalImportSupport: true,
          inlineRequires: true,
        },
      }),
    },
    resolver: {
      assetExts: assetExts.filter(ext => ext !== 'svg'),
      sourceExts: process.env.RN_SRC_EXT
        ? process.env.RN_SRC_EXT.split(',').concat([
            ...sourceExts,
            'svg',
            'cjs',
          ])
        : [...sourceExts, 'svg', 'cjs'],
    },
    serializer: {
      processModuleFilter: module => {
        return !module.path.endsWith(
          'react-native/Libraries/Renderer/implementations/ReactFabric-prod.js',
        );
      },
    },
  };
})();
