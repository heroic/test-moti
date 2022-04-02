import React from 'react';
import {StyleProp, StyleSheet, Text, ViewStyle} from 'react-native';
import Animated, {useAnimatedStyle} from 'react-native-reanimated';
// import Text from '../../../components/Text';

interface Props {
  style?: StyleProp<ViewStyle>;
  onPress: () => void;
  showEmis: boolean;
}

export const PayInEmiButton = ({style, onPress, showEmis}: Props) => {
  // const [showEmis, setShowEmis] = useState(false);

  // const {t, ready} = useTranslation(['transactionHistory'], {
  //   useSuspense: false,
  // });

  const animatedStyle = useAnimatedStyle(() => {
    return {
      transform: [
        {
          rotate: '270deg',
        },
      ],
    };
  }, []);

  return (
    // <Button
    //   appearance="secondary"
    //   raised
    //   category="small"
    //   style={style}
    //   onPress={onPress}>
    //   <Row style={styles.buttonRow}>
    <Animated.View style={animatedStyle}>
      <Text style={styles.payInEmi}>
        {/* {t('transactionHistory:convertToEmi')} */}
        abc
      </Text>
    </Animated.View>
    //     <Dropdown style={styles.down} />
    //   </Row>
    // </Button>
  );
};

const styles = StyleSheet.create({
  buttonRow: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  payInEmi: {
    marginRight: 8,
  },
  down: {
    transform: [{rotate: '270deg'}],
  },
});
