package net.timeboxing.guice.vaadin;

import net.timeboxing.vaadin.component.ComponentAdapter;
import net.timeboxing.vaadin.component.ComponentFactories;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import javax.inject.Provider;
import java.util.Optional;

public class ComponentAdapterTest {

    @Mock
    private Provider<ComponentFactories> componentFactoriesProvider;

    @Mock
    private ComponentFactories componentFactories;

    @Test
    public void adaptCallsProvider() {
        // given
        Provider<ComponentFactories> componentFactoriesProvider = ComponentFactories::new;
        Mockito.when(componentFactoriesProvider.get()).thenReturn(componentFactories);
        Mockito.when(componentFactories.get(Mockito.any(), Mockito.any())).thenReturn(Optional.empty());
        ComponentAdapter.initialize(componentFactoriesProvider);

        // when

        // then
        Assert.assertTrue();
    }


}
