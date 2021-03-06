package net.explorviz.repository;

import java.util.Queue;

import explorviz.live_trace_processing.configuration.Configuration;
import explorviz.live_trace_processing.configuration.ConfigurationFactory;
import explorviz.live_trace_processing.filter.SinglePipeConnector;
import explorviz.live_trace_processing.main.FilterConfiguration;
import explorviz.live_trace_processing.record.IRecord;

public class RepositoryStarter {
	public void start(final LandscapeRepositoryModel model) {
		final SinglePipeConnector<IRecord> modelConnector = new SinglePipeConnector<IRecord>(64);

		new LandscapeRepositorySink(modelConnector, model).start();

		final Queue<IRecord> sink = modelConnector.registerProducer();

		final Configuration configuration = ConfigurationFactory.createSingletonConfiguration();

		FilterConfiguration.configureAndStartFilters(configuration, sink);
	}
}
