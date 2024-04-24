package com.android.example.libfinal.dependencyinjection

import android.content.Context
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideFirebaseUtil() = FirebaseUtil()

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context) = SharePreferenceUtil(context)

    @Singleton
    @Provides
    fun provideApplication() = ShopKartApplication()

    @Singleton
    @Provides
    fun provideProductsAdapter() = ProductsAdapter()

    @Singleton
    @Provides
    fun provideDashboardProductsAdapter() = DashboardProductsAdapter()

    @Singleton
    @Provides
    fun provideCartListAdapter() = CartListAdapter()

    @Singleton
    @Provides
    fun provideAddressListAdapter() = AddressListAdapter()

    @Singleton
    @Provides
    fun provideOrderListAdapter() = OrderListAdapter()

    @Singleton
    @Provides
    fun provideSoldProductListAdapter() = SoldProductListAdapter()
}