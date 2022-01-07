import React, {useEffect} from 'react';
import { Text, View , NativeModules, Image} from 'react-native';

const App = () => {

  useEffect(() => {
    NativeModules.ShakeBugAndroid.shakeBugInit()
  }, []);

  return (
    <View
      style={{
        flex: 1,
        justifyContent: "center",
        alignItems: "center"
      }}>
      <Text style={{fontSize:30}}>ShakeBug Demo </Text>
    </View>
  )
}


export default App;