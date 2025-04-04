import { NavigationContainer } from '@react-navigation/native'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import Ionicons from 'react-native-vector-icons/Ionicons'
import colors from '../styles/colors'
import Pizza from '../pages/Pizza'
import Hamburguer from '../pages/Hamburguer'
import Drinks from '../pages/Drinks'

const Tab = createBottomTabNavigator()

export default function MyTab() {
    return (
        <NavigationContainer>
            <Tab.Navigator
                screenOptions={({ route }) => ({
                    tabBarIcon: ({ focused, color, size }) => {
                        let iconName

                        switch (route.name) {
                            case 'Pizza':
                                iconName = focused ? 'pizza': 'pizza-outline'
                                break
                            case 'Hamburguer':
                                iconName = focused? 'fast-food': 'fast-food-outline'
                                break
                            case 'Drinks':
                                iconName = focused? 'beer': 'beer-outline'
                        }
                        
                        return <Ionicons name={iconName} size={size} color={color} />
                    },
                    tabBarActiveTintColor: colors.highlightColor,
                    tabBarInactiveTintColor: colors.secondaryTextColor,
                    headerShown: false
                })}
            >
                <Tab.Screen name="Pizza" component={Pizza} options={{ title: 'Pizza' }}/>
                <Tab.Screen name="Hamburguer" component={Hamburguer} options={{ title: 'Hamburguer' }}/>
                <Tab.Screen name="Drinks" component={Drinks} options={{ title: 'Drinks' }}/>
            </Tab.Navigator>
        </NavigationContainer>
    )
}
