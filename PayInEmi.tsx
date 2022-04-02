import {MotiView} from 'moti';
import React from 'react';
import {StyleProp, StyleSheet, Text, ViewStyle} from 'react-native';
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

  return (
    // <Button
    //   appearance="secondary"
    //   raised
    //   category="small"
    //   style={style}
    //   onPress={onPress}>
    //   <Row style={styles.buttonRow}>
    <MotiView from={{scale: 1}} animate={{scale: 2}}>
      <Text style={styles.payInEmi}>
        {/* {t('transactionHistory:convertToEmi')} */}
        abc
      </Text>
    </MotiView>
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
