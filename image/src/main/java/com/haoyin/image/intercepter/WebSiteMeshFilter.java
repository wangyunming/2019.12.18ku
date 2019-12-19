package com.haoyin.image.intercepter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class WebSiteMeshFilter extends ConfigurableSiteMeshFilter{
	public static final String DECORATOR_URL="/layout/site-nav.ftl";
	public static final String DECORATOR_ORDER_URL="/layout/direct-nav.ftl";
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder
        .addDecoratorPath("/home.html", DECORATOR_URL)
        .addDecoratorPath("/order/settingDirect.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/order/update-order-detail.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/order/order-*.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/order/finished-order.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/order/ongoing-order.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/fileList.html", DECORATOR_URL)
        .addDecoratorPath("/oem-fileList.html", DECORATOR_URL)
        .addDecoratorPath("/admin/add.html",DECORATOR_URL)
        .addDecoratorPath("/file-generation.html", DECORATOR_URL)
        .addDecoratorPath("/file-upload.html", DECORATOR_URL)
        .addDecoratorPath("/excel-initial-info.html", DECORATOR_URL)
        .addDecoratorPath("/order/advance-order.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/cart/shopping-cart.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/order/select-order-type.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/order/order-file-upload.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/pay/notify.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/invoice/makeInvoice.html", DECORATOR_URL)
        .addDecoratorPath("/invoice/invoiceRecords.html", DECORATOR_URL)
        .addDecoratorPath("/invoice/invoiceInformation.html", DECORATOR_URL)
        .addDecoratorPath("/order/order-file-upload-no.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/pay/pay-success-good.html", DECORATOR_ORDER_URL)
        .addDecoratorPath("/yeePay/sync.html", DECORATOR_ORDER_URL)
        .addExcludedPath(DECORATOR_URL)//不需要装饰的路径
        ;
		super.applyCustomConfiguration(builder);
	}
	
}
