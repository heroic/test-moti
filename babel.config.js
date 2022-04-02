module.exports = {
  presets: ['module:metro-react-native-babel-preset'],
  plugins: [['react-native-reanimated/plugin']],
  env: {
    production: {
      plugins: [
        '@babel/plugin-proposal-export-namespace-from',
        'transform-remove-console',
      ],
    },
  },
};
